package cn.jsnu.css.service.Impl;

import cn.jsnu.css.dao.AddressMapper;
import cn.jsnu.css.pojo.Address;
import cn.jsnu.css.service.AddressService;
import cn.jsnu.css.utils.RandomId;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 魏荣轩-18090248
 * @date 2020/5/24 1:12
 */
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;
    /**
     * 新增一个地址
     *
     * @param userId        用户ID
     * @param province      省
     * @param city          市
     * @param district      区
     * @param detailAddress 详细地址
     * @param contact       联系人
     * @param phoneNum      电话
     */
    @Override
    public void addAddress(String userId, String province, String city, String district, String detailAddress, String contact, String phoneNum) {
        String addressId= RandomId.getRandomAddressId();
        while(addressMapper.findAddressByAddressId(addressId)!=null){
            addressId= RandomId.getRandomAddressId();
        }
        addressMapper.addAddress(new Address(addressId,userId,province,city,district,detailAddress,contact,phoneNum));
    }

    /**
     * 根据地址ID获取地址详情
     *
     * @param addressId 地址ID
     * @return 地址类
     */
    @Override
    public Address findAddressByAddressId(String addressId) {
        return addressMapper.findAddressByAddressId(addressId);
    }

    /**
     * 根据玩家ID获取地址类表
     *
     * @param userId 玩家ID
     * @return 地址表
     */
    @Override
    public List<Address> findAddressByUserId(String userId) {
        return addressMapper.findAddressByUserId(userId);
    }

    /**
     * 根据地址ID修改省份
     *
     * @param addressId 地址ID
     * @param province  省份
     */
    @Override
    public void updateProvinceByAddressId(String addressId, String province) {
        Address address=new Address();
        address.setAddressId(addressId);
        address.setProvince(province);
        addressMapper.updateProvinceByAddressId(address);
    }

    /**
     * 根据地址ID修改地址城市
     *
     * @param addressId 地址ID
     * @param city      市
     */
    @Override
    public void updateCityByAddressId(String addressId, String city) {
        Address address=new Address();
        address.setAddressId(addressId);
        address.setCity(city);
        addressMapper.updateCityByAddressId(address);
    }

    /**
     * 根据地址ID修改地址区
     *
     * @param addressId 地址ID
     * @param district  地区
     */
    @Override
    public void updateDistrictByAddressId(String addressId, String district) {
        Address address=new Address();
        address.setAddressId(addressId);
        address.setDistrict(district);
        addressMapper.updateDistrictByAddressId(address);
    }

    /**
     * 修改地址信息
     * @param address 地址对象
     */
    @Override
    public void updateAddressByAddressId(Address address) {
        addressMapper.updateAddressByAddressId(address);
    }


    /**
     * 根据地址ID修改详细地址
     *
     * @param addressId     地址Id
     * @param detailAddress 详细地址
     */
    @Override
    public void updateDetailAddressByAddressId(String addressId, String detailAddress) {
        Address address=new Address();
        address.setAddressId(addressId);
        address.setDetailAddress(detailAddress);
        addressMapper.updateDetailAddressByAddressId(address);
    }

    /**
     * 根据地址ID修改地址联系人
     *
     * @param addressId 地址ID
     * @param contact   联系人
     */
    @Override
    public void updateContactByAddressId(String addressId, String contact) {
        Address address=new Address();
        address.setAddressId(addressId);
        address.setContact(contact);
        addressMapper.updateContactByAddressId(address);
    }

    /**
     * 根据用户ID修改地址联系人
     *
     * @param userId  用户ID
     * @param contact 联系人
     */
    @Override
    public void updateContactByUserId(String userId, String contact) {
        Map<String,String> data=new HashMap<>(2);
        data.put("userId",userId);
        data.put("contact",contact);
        addressMapper.updateContactByUserId(data);
    }

    /**
     * 根据地址Id修改地址手机号
     *
     * @param addressId 地址ID
     * @param phoneNum  电话号
     */
    @Override
    public void updatePhoneNumByAddressId(String addressId, String phoneNum) {
        Address address=new Address();
        address.setAddressId(addressId);
        address.setPhoneNum(phoneNum);
        addressMapper.updatePhoneNumByAddressId(address);
    }

    /**
     * 根据手机号查找地址
     *
     * @param phoneNum 手机号
     * @return 地址合集
     */
    @Override
    public List<Address> findAddressByPhoneNum(String phoneNum) {
        return addressMapper.findAddressByPhoneNum(phoneNum);
    }

    /**
     * 根据联系人获取地址
     *
     * @param contact 联系人
     * @return 地址合集
     */
    @Override
    public List<Address> findAddressByContact(String contact) {
        return addressMapper.findAddressByContact(contact);
    }
}
