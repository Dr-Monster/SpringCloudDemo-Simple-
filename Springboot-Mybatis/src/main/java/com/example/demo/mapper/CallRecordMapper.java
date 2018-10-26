package com.example.demo.mapper;


import com.example.demo.dto.CallDto;
import com.example.demo.dto.RecordDto;

import java.util.List;

public interface CallRecordMapper {

    List<CallDto> getAllCallRecord();

    void refreshList();

    List<CallDto> getCallRecordByID(RecordDto recordDto);

    List<CallDto> getCallRecordByIDWithoutLimit(RecordDto recordDto);

    int addCallRecord(List<CallDto> callDtoList);
}
