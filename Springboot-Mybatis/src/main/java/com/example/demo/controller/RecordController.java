package com.example.demo.controller;


import com.example.demo.dto.*;
import com.example.demo.mapper.CallRecordMapper;
import com.example.demo.mapper.VisitRecordMapper;
import com.example.demo.service.RecordService;
import com.example.demo.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * luhaoran
 * 通话记录新增及查询功能
 * 拜访记录新增及查询功能
 */

@RequestMapping(value = "/record")
@Controller
public class RecordController {

    @Autowired
    RecordService recordService;

    @Autowired
    VisitRecordMapper visitRecordMapper ;

    @Autowired
    CallRecordMapper callRecordMapper ;


    @RequestMapping(value = "/addVisit" , method = RequestMethod.POST)
    @ResponseBody
    public ResponseVo addVisit(@RequestBody List<VisitDto> visitDtoList , HttpServletRequest request , HttpServletResponse response){
        int checkID = recordService.addVisitRecord(visitDtoList);
        if(checkID != 0){
            return ResponseUtil.buildVoByResponseCode2(ResponseCode.SUCCESS);
        }else{
            return ResponseUtil.buildVoByResponseCode2(ResponseCode.SYSTEM_ERROR);
        }
    }


    @RequestMapping(value = "/queryVisit" , method = RequestMethod.POST)
    @ResponseBody
    public ResponseVo queryVisit(@RequestBody RecordDto recordDto , HttpServletRequest request , HttpServletResponse response){
        List<VisitDto> data = recordService.getVisitRecordByID(recordDto);
        int total = visitRecordMapper.getVisitRecordByIDWithoutLimit(recordDto).size();
        Map<String , Object> map = new HashMap<>();
        map.put("rows" , data);
        map.put("total" , total);
        map.put("count", data.size());
        if(data != null){
            return  ResponseUtil.buildVoByResponseCode(true , ResponseCode.SUCCESS , map);
        }else{
            return ResponseUtil.buildVoByResponseCode2(ResponseCode.SYSTEM_ERROR);
        }
    }


    @RequestMapping(value = "/addCall" , method = RequestMethod.POST)
    @ResponseBody
    public ResponseVo addCall(@RequestBody List<CallDto> callDtoList , HttpServletRequest request , HttpServletResponse response){
        int checkID = recordService.addCallRecord(callDtoList);
        if(checkID != 0){
            return ResponseUtil.buildVoByResponseCode2(ResponseCode.SUCCESS);
        }else{
            return ResponseUtil.buildVoByResponseCode2(ResponseCode.SYSTEM_ERROR);
        }
    }

    @RequestMapping(value = "/queryCall" , method = RequestMethod.POST)
    @ResponseBody
    public ResponseVo queryCall(@RequestBody RecordDto recordDto , HttpServletRequest request , HttpServletResponse response){
        List<CallDto> data = recordService.getCallRecordByID(recordDto);
        int total = callRecordMapper.getCallRecordByIDWithoutLimit(recordDto).size();
        Map<String , Object> map = new HashMap<>();
        map.put("rows" , data);
        map.put("total" , total);
        map.put("count", data.size());
        if(data != null){
            return  ResponseUtil.buildVoByResponseCode(true , ResponseCode.SUCCESS , map);
        }else{
            return ResponseUtil.buildVoByResponseCode2(ResponseCode.SYSTEM_ERROR);
        }
    }
}