package cn.nhu.service.impl;

import cn.nhu.dao.CKUsedDao;
import cn.nhu.domain.CKUsed;
import cn.nhu.info.CKUsedInfo;
import cn.nhu.service.CKUsedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ckUsedService")
public class CKUsedServiceImpl implements CKUsedService {

    @Autowired
    private CKUsedDao ckUsedDao;

    /*
    查找视图中车间待接收信息
     */
    @Override
    public List<CKUsedInfo> findCKUsedInfoNotReceived(Long id, String beginDate, String endDate) {
        return ckUsedDao.findCKUsedInfoNotReceived(id, beginDate, endDate);
    }

    @Override
    public List<CKUsedInfo> findCKUsedInfo(Long userid, String beginDate, String endDate) {
        return DateFormatCKUser(ckUsedDao.findCKUsedInfo(userid, beginDate, endDate));
    }

    @Override
    public List<CKUsedInfo> findCKUsedInfoByType(Integer typeId, String beginDate, String endDate){
        return DateFormatCKUser(ckUsedDao.findCKUsedInfoByType(typeId, beginDate, endDate));
    }

    @Override
    public int updateCKUsedInfo(CKUsed ckUsed) {
        return ckUsedDao.updateCKUsedInfo(ckUsed);
    }

    @Override
    public int addCKUsedInfo(CKUsed ckUsed) {
        return ckUsedDao.addCKUsedInfo(ckUsed);
    }

    /**
     * 转化TheDate属性值为yyyy/MM/dd格式
     *
     * @param list
     * @return
     */
    public List<CKUsedInfo> DateFormatCKUser(List<CKUsedInfo> list) {
        for (CKUsedInfo info : list) {
            info.setThedate(info.getThedate().replace('-', '/').substring(0, 10));
        }
        return list;
    }


}
