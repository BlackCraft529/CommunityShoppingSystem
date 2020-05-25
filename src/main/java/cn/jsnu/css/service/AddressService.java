package cn.jsnu.css.service;

import cn.jsnu.css.pojo.Address;
import java.util.List;

/**
 * @author 魏荣轩-18090248
 * @date 2020/5/24 1:06
 */
public interface AddressService {

    /**
     * 新增一个地址
     * @param userId 用户ID
     * @param province 省
     * @param city 市
     * @param district 区
     * @param detailAddress 详细地址
     * @param contact 联系人
     * @param phoneNum 电话
     */
    void addAddress(String userId,String province,String city,String district,String detailAddress,String contact,String phoneNum);

    /**
     * 根据地址ID获取地址详情
     * @param addressId 地址ID
     * @return 地址类
     */
    Address findAddressByAddressId(String addressId);

    /**
     * 根据玩家ID获取地址类表
     * @param userId 玩家ID
     * @return 地址表
     */
    List<Address> findAddressByUserId(String userId);

    /**
     * 根据地址ID修改省份
     * @param addressId 地址ID
     * @param province 省份
     */
    void updateProvinceByAddressId(String addressId,String province);

    /**
     * 根据地址ID修改地址城市
     * @param addressId 地址ID
     * @param city 市
     */
    void updateCityByAddressId(String addressId,String city);

    /**
     * 根据地址ID修改地址区
     * @param addressId 地址ID
     * @param district 地区
     */
    void updateDistrictByAddressId(String addressId,String district);

    /**
     * 根据地址ID修改详细地址
     * @param addressId 地址Id
     * @param detailAddress 详细地址
     */
    void updateDetailAddressByAddressId(String addressId,String detailAddress);

    /**
     * 根据地址ID修改地址联系人
     * @param addressId 地址ID
     * @param contact 联系人
     */
    void updateContactByAddressId(String addressId,String contact);

    /**
     * 根据用户ID修改地址联系人
     * @param userId 用户ID
     * @param contact 联系人
     */
    void updateContactByUserId(String userId,String contact);

    /**
     * 根据地址Id修改地址手机号
     * @param addressId 地址ID
     * @param phoneNum 电话号
     */
    void updatePhoneNumByAddressId(String addressId,String phoneNum);

    /**
     * 根据手机号查找地址
     * @param phoneNum 手机号
     * @return 地址合集
     */
    List<Address> findAddressByPhoneNum(String phoneNum);

    /**
     * 根据联系人获取地址
     * @param contact 联系人
     * @return 地址合集
     */
    List<Address> findAddressByContact(String contact);
}
