package cn.nhu.controller;

import cn.nhu.info.CKUsedInfo;
import cn.nhu.info.StartStopDate;
import cn.nhu.service.CKUsedService;
import cn.nhu.service.ProductService;
import cn.nhu.service.ProductTypeService;
import cn.nhu.service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final ProductTypeService productTypeService;
    private final CKUsedService ckUsedService;
    private final UserService userService;

    @Autowired
    public ProductController(ProductService productService, ProductTypeService productTypeService, CKUsedService ckUsedService, UserService userService) {
        this.productService = productService;
        this.productTypeService = productTypeService;
        this.ckUsedService = ckUsedService;
        this.userService = userService;
    }

    @RequestMapping("/productList.html")
    public String to(Model model, HttpSession session) {

        Object userObj = session.getAttribute("user");
        if (userObj != null) {
            try {
                setAttribute(model);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "ProductList";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping("/CKUsed.html")
    @ResponseBody
    public String CKUsed(@RequestParam("year") String year, @RequestParam("month") String month, HttpSession session) {

        System.out.println(year);
        System.out.println(month);
        Object userObject = session.getAttribute("user");
        if (userObject != null) {
            try {
                StartStopDate date = new StartStopDate(year, month);
                ArrayList<Object> objects = new ArrayList<>();
                for (int i = 1; i < 5; i++) {
                    List<CKUsedInfo> ckUsedlist = ckUsedService.findCKUsedInfoByType(i, date.getStartDate(), date.getStopDate());
                    for (CKUsedInfo info : ckUsedlist) {
                        //将list中的元素转化为json对象
                        JSONObject jsonObject = JSONObject.fromObject(info);
                        System.out.println(jsonObject.toString());
                        //放入list
                        objects.add(jsonObject);
                    }
                }
                //将list转换
                JSONArray fromObject = JSONArray.fromObject(objects);
                System.out.println(fromObject.toString());
                return fromObject.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return "failed";
            }
        } else {
            return "notLogged";
        }
    }

    /**
     * 设置listde的属性，四种产品类型的导航页属性设置，标签页下各种物料属性设置
     *
     * @param model
     */
    private void setAttribute(Model model) {

        //四种类型
        model.addAttribute("typeArr", productTypeService.getProductTypeList());
        for (int i = 1; i < 5; i++) {
            model.addAttribute("Col" + i, productService.getProductInfoListByType(i));
        }

    }

}
