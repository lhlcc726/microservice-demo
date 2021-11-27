package com.lihoulai.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lihoulai.demo.entity.Customers;
import com.lihoulai.demo.exception.NotFundException;
import com.lihoulai.demo.mapper.CustomersMapper;
import com.lihoulai.demo.service.CustomersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lihoulai
 * @since 2021-11-21
 */
@Service
public class CustomersServiceImpl extends ServiceImpl<CustomersMapper, Customers> implements CustomersService {
    @Autowired
    private CustomersMapper customersMapper;
    @Override
    public List<Customers> findAllCustomers() {
        QueryWrapper queryWrapper=new QueryWrapper();
        List<Customers> customersList=customersMapper.selectList(queryWrapper);
        return customersList;
    }

    @Override
    public Customers getCustomerById(Long id) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("customer_id",id);
        Customers customer=customersMapper.selectOne(queryWrapper);
        if(customer==null){throw new NotFundException("hi,we couldent find the customer of id "+id);
        }
        return customer;
    }
}
