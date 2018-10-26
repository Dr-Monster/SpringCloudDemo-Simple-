package com.example.demo.mapper;


import com.example.demo.dto.RecordDto;
import com.example.demo.dto.VisitDto;

import java.util.List;

public interface VisitRecordMapper {
    List<VisitDto> getAllVisitRecord();

    List<VisitDto> getVisitRecordByID(RecordDto recordDto);

    List<VisitDto> getVisitRecordByIDWithoutLimit(RecordDto recordDto);

    int addVisitRecord(List<VisitDto> visitDtoList);

}
