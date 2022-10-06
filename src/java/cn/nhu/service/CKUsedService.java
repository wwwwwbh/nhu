package cn.nhu.service;

import cn.nhu.domain.CKUsed;
import cn.nhu.info.CKUsedInfo;

import java.util.List;

public interface CKUsedService {

    List<CKUsedInfo> findCKUsedInfoNotReceived(Long id, String beginDate, String endDate);

    List<CKUsedInfo> findCKUsedInfo(Long userid, String beginDate, String endDate);

    List<CKUsedInfo> findCKUsedInfoByType(Integer typeId, String beginDate, String endDate);

    int updateCKUsedInfo(CKUsed ckUsed);

    int addCKUsedInfo(CKUsed ckUsed);
}
