package com.ace2.mybatis.service;

import com.ace2.mybatis.mapper.MpfaMapper;
import com.ace2.mybatis.models.Function;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Classname: MpfaMapperImpl
 * @Date: 2023/2/22 下午 07:02
 * @Author: kalam_au
 * @Description:
 */

@Service
public class MpfaService {
    private static final Logger log = LogManager.getLogger(MpfaService.class.getName());

    private final MpfaMapper mpfaMapper;

    @Autowired
    public MpfaService(MpfaMapper mpfaMapper) {
        this.mpfaMapper = mpfaMapper;
    }


    public List<Function> getFunctions(String applId, String userId) {
        return mpfaMapper.getFunctions(applId, userId);
    }

    public List<Function> getFunctions(String applId, String funcId, String userId) {
        return mpfaMapper.getFunctions(applId, userId, userId);
    }

    public List<Function> getChildFunctions(String applId, String funcId, String userId) {
        return mpfaMapper.getChildFunctions(applId, userId, userId);
    }


}

