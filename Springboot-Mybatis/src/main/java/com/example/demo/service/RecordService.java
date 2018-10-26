package com.example.demo.service;


import com.example.demo.dto.CallDto;
import com.example.demo.dto.RecordDto;
import com.example.demo.dto.VisitDto;
import com.example.demo.mapper.CallRecordMapper;
import com.example.demo.mapper.VisitRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class RecordService {

    @Autowired
    VisitRecordMapper visitRecordMapper ;

    @Autowired
    CallRecordMapper callRecordMapper ;

    public Date timeTrans(String time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null ;
        try {
            date = simpleDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date ;
    }

    public List<VisitDto> getVisitRecordByID(RecordDto recordDto){
        List<VisitDto> visitDtoList = visitRecordMapper.getVisitRecordByID(recordDto);
        Collections.sort(visitDtoList, new Comparator<VisitDto>() {
            @Override
            public int compare(VisitDto v1, VisitDto v2) {
                if(timeTrans(v1.getVisitTime()).before(timeTrans(v2.getVisitTime()))){
                    return 1;
                }
                else if(timeTrans(v1.getVisitTime()).after(timeTrans(v2.getVisitTime()))){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        });
        return visitDtoList;
    }

    public int addVisitRecord(List<VisitDto> visitDtoList){
        return visitRecordMapper.addVisitRecord(visitDtoList);
    }

    public List<CallDto> getCallRecordByID(RecordDto recordDto){
        List<CallDto> callDtoList = callRecordMapper.getCallRecordByID(recordDto);
        Collections.sort(callDtoList, new Comparator<CallDto>() {
            @Override
            public int compare(CallDto c1, CallDto c2) {
                if(timeTrans(c1.getCallTime()).before(timeTrans(c2.getCallTime()))){
                    return 1;
                }
                else if(timeTrans(c1.getCallTime()).after(timeTrans(c2.getCallTime()))){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        });
        return callDtoList ;
    }

    public int addCallRecord(List<CallDto> callDtoList){
        List<CallDto> callDtos = callRecordMapper.getAllCallRecord();
        Set<CallDto> callDtoSet = new HashSet<>();
        callDtoSet.addAll(callDtoList);
        callDtoSet.addAll(callDtos);
        List<CallDto> mixList = new ArrayList<>();
        Iterator<CallDto> iterator = callDtoSet.iterator();
        while(iterator.hasNext()){
            mixList.add(iterator.next());
        }
        callRecordMapper.refreshList();
        return callRecordMapper.addCallRecord(mixList);
    }
}
