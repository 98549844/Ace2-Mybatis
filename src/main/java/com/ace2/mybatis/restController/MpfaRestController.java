package com.ace2.mybatis.restController;

import com.ace2.mybatis.mapper.MpfaMapper;
import com.ace2.mybatis.service.MpfaService;
import com.ace2.mybatis.models.Function;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname: MpfaRestController
 * @Date: 2023/2/22 下午 05:00
 * @Author: kalam_au
 * @Description:
 */


@RestController
public class MpfaRestController {
    private static final Logger log = LogManager.getLogger(MpfaRestController.class.getName());

    private final MpfaMapper mpfaMapper;
    private final MpfaService mpfaService;


    @Autowired
    public MpfaRestController(MpfaMapper mpfaMapper, MpfaService mpfaService) {
        this.mpfaMapper = mpfaMapper;
        this.mpfaService = mpfaService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/mpfa/isAuthorized")
    public boolean isAuthorized() {
        String applId = "FWFMG";
        String funcId = "FMG001S01";
        String userId = "USER1";

        List<Function> functions = mpfaMapper.isAuthorized2(applId, funcId, userId);

        int i = 0;
        for (Function f : functions) {
            ++i;
            System.out.println(i + ".  " + f);
        }

        log.info("mpfaMapper.isExist():   " + mpfaMapper.isExist());
        log.info("mpfaMapper.isNotExist():   " + mpfaMapper.isNotExist());


        boolean a = mpfaMapper.isExist();
        boolean b = mpfaMapper.isNotExist();
        System.out.println("a:   " + a);
        System.out.println("b:   " + b);

        boolean c = mpfaMapper.isAuthorized(applId, funcId, userId);
        System.out.println("C:   " + c);

        return false;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/mpfa/getFunctions")
    public boolean getFunctions() {
        String applId = "FWFMG";
        String funcId = "FMG001S01";
        String userId = "USER1";

        List<Function> functions = mpfaService.getFunctions(applId, funcId);
        List<Function> childFunctions = mpfaService.getFunctions(applId, funcId, userId);

        for (Function f : functions) {
            System.out.println(f);
        }
        System.out.println("------------------------");

        for (Function f : childFunctions) {
            System.out.println(f);
        }

        return false;
    }

}

