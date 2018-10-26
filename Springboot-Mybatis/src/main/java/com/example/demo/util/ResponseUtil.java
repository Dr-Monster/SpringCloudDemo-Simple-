/*
 * Copyright (C) 2006-2014 Zbjk All rights reserved
 * Author: liukun2
 * Date: 2014-8-26
 * Description:ResponseUtil.java
 */
package com.example.demo.util;

import com.example.demo.dto.ResponseCode;
import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.ResponseVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseUtil {

    private ResponseUtil() {
    }

    /**
     * 自定义参数返回结构
     * @param result
     * @param code
     * @param msg
     * @param data
     * @return
     */
    public static ResponseDto<Object> buildVo(boolean result, String code, String msg, Object data) {
        ResponseDto<Object> vo = new ResponseDto<>();
        vo.setSuccess(result);
        vo.setCode(Integer.valueOf(code));
        vo.setMsg(msg);
        if(	data instanceof List){
            @SuppressWarnings("unchecked")
            List<Object> list = (List<Object>)data;
            vo.setData(getListJsonData(list));
        }else{
            vo.setData(data);
        }
        return vo;
    }

    public static ResponseVo buildVoByResponseCode(Boolean success, ResponseCode ResponseCode) {
        return buildVoByResponseCode(success, ResponseCode, null);
    }

    public static ResponseVo buildVoByResponseCode(Boolean success, String code, String msg) {
        ResponseVo vo = new ResponseVo();
        vo.setSuccess(success);
        vo.setCode(Integer.valueOf(code));
        vo.setMsg(msg);
        return vo;
    }

    @SuppressWarnings("rawtypes")
    public static ResponseVo buildVoByResponseCode(Boolean success, ResponseCode ResponseCode, Object data) {
        ResponseVo vo = new ResponseVo();
        if (data instanceof Map) {
            vo.setData(data);
        } else if (data instanceof List) {
            List list = (List) data;
            vo.setData(getListJsonData(list, null));
        } else {
            vo.setData(data);
        }

        vo.setSuccess(success);
        vo.setCode(ResponseCode.getCode());
        vo.setMsg(ResponseCode.getMsg());
        return vo;
    }

    @SuppressWarnings("rawtypes")
    public static ResponseVo buildVoByResponseCode(Boolean success, ResponseCode ResponseCode, Object data, int count) {
        ResponseVo vo = new ResponseVo();
        if (data instanceof Map) {
            vo.setData(data);
        } else if (data instanceof List) {
            List list = (List) data;
            vo.setData(getListJsonData(list, count));
        } else {
            vo.setData(data);
        }

        vo.setSuccess(success);
        vo.setCode(ResponseCode.getCode());
        vo.setMsg(ResponseCode.getMsg());
        return vo;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static Map getListJsonData(List list, Integer count) {
        Map map = new HashMap();
        if (count == null) {
            map.put("count", list.size());
        } else {
            map.put("count", count);
        }
        map.put("rows", list);
        return map;
    }

    /**
     * 把data附加一个数据条数
     * @param list
     * @return
     */
    private static Map<String,Object> getListJsonData(List<Object> list) {
        Map<String,Object> map = new HashMap<>();
        map.put("count", list.size());
        map.put("rows", list);
        return map;
    }


    /**
     * 依据code构造返回结构
     * @param code
     * @return
     */

    public static ResponseDto<Object> buildVoByResponseCode(ResponseCode code) {
        ResponseDto<Object> vo = new ResponseDto<>();
        vo.setSuccess(code.isSuccess());
        vo.setCode(code.getCode());
        vo.setMsg(code.getMsg());
        return vo;
    }

    public static ResponseVo buildVoByResponseCode2(ResponseCode code) {
        ResponseVo vo = new ResponseVo();
        vo.setSuccess(code.isSuccess());
        vo.setCode(code.getCode());
        vo.setMsg(code.getMsg());
        return vo;
    }

    /**
     * 依据code和data构造返回结构
     * @param code
     * @param data
     * @return
     */
    public static ResponseDto<Object> buildVoByResponseCode(ResponseCode code, Object data) {
        return buildVo(code.isSuccess(),code.getCode().toString(),code.getMsg(),data);
    }
}
