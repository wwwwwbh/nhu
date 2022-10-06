package cn.nhu.controller;

import cn.nhu.domain.User;
import cn.nhu.service.ProductService;
import cn.nhu.service.ProductTypeService;
import cn.nhu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * 用户web层
 */
//调用service方法，整合SpringMVC成功
//得有service对象，依赖注入，交给IOC容器
//Spring整合SpringMVC，在启动tomocat时，需要Spring配置文件
//服务器启动时创建SercletContext对象，关闭时销毁
//一类监听器，监听SercletContext对象创建和销毁
//监听器去加载Spring配置文件，创建WEB工厂，存储SercletContext对象
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final ProductService productService;
    private final ProductTypeService productTypeService;

    @Autowired
    public UserController(UserService userService, ProductService productService, ProductTypeService productTypeService) {
        this.userService = userService;
        this.productService = productService;
        this.productTypeService = productTypeService;
    }

    @RequestMapping("/logout.html")
    public String logout(HttpSession session) {
        //查询的单个用户
        session.removeAttribute("user");
        session.invalidate();

        return "redirect:/";
    }

    @RequestMapping("/modifypwd.html")
    public String modifyPwd(HttpSession session) {
        //查询的单个用户
/*/       session.removeAttribute("user");
        session.invalidate();*/

        return "redirect:/";
    }

    @RequestMapping("/main.html")
    public ModelAndView toSecurity(Model model, HttpSession session) {
        Object userObj = session.getAttribute("user");
        if (userObj != null) {
            //设置产品类型
            model.addAttribute("typeArr", productTypeService.getProductTypeList());
            //四个列集合
            setCol(model);
            //设置部门
            model.addAttribute("deptArr",userService.findDeptName());
            System.out.println("准备转向保卫处界面");
            return new ModelAndView("Main");
        } else {
            return new ModelAndView("redirect:/");
        }
    }
    //用于设置车间使用量的列
    private void setCol(Model model) {
        for (int i = 1; i < 5; i++) {
            model.addAttribute("Col" + i, productService.getProductInfoListByType(i));
        }
    }

    @RequestMapping("/Warehouse.html")
    public ModelAndView toWarehouse(Model model, HttpSession session) {
        Object userObj = session.getAttribute("user");
        if (userObj != null) {
            /*数据*/
            System.out.println("准备转向仓库界面");
            return new ModelAndView("Warehouse");
        } else {
            return new ModelAndView("redirect:/");
        }
    }

    @RequestMapping("/Dept.html")
    public ModelAndView toDept(Model model, HttpSession session) {
        Object userObj = session.getAttribute("user");
        if (userObj != null) {
            /*数据*/
            System.out.println("准备转向部门界面");
            return new ModelAndView("Dept");
        } else {
            return new ModelAndView("redirect:/");
        }
    }

    @RequestMapping("/testName")
    @ResponseBody
    public String testName(@RequestParam String name){
        if(userService.existUserName(name)){
            if (userService.selectIsEffective(name)) {
                return "success";
            }
            else{
                return "fail";
            }
        }
        else{
            return "error";
        }
    }

    @RequestMapping("/login.html")
    @ResponseBody
    public String userLogin(@RequestParam String user, HttpSession session) {
        //转化为User类
        User userObj = userService.formatUser(user);
        try {
            if (userService.existUserName(userObj.getUsername())) {
                //账户存在
                if (userService.selectIsEffective(userObj.getUsername())) {
                    //账户有效
                    if (userService.selectUserPwd(userObj.getUsername(), userObj.getUserpwd())) {
                        session.setAttribute("user", userObj);
                        //判断账户类型
                        long id = userService.findUserId(userObj.getUsername());
                        //System.out.println(id);
                        if (id == 1L) {
                            return "security";
                        } else if (id == 2L) {
                            return "warehouse";
                        } else {
                            return "dept";
                        }
                    } else {
                        return "pwdError";
                    }
                } else {
                    return "AccountNotEffective";
                }
            } else {
                //账号不存在
                return "NoUserName";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
    }

}
