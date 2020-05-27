package cn.jsnu.css.dao;

import cn.jsnu.css.pojo.Address;
import java.util.List;
import java.util.Map;

/**
 * @author 魏荣轩-18090248
 * @date 2020/5/24 0:23
 */
public interface AddressMapper {

    /**
     * 新增一个地址
     * @param address 地址类
     */
    void addAddress(Address address);

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
     * 根据地址ID修改地址省份
     * @param address 地址类
     */
    void updateProvinceByAddressId(Address address);

    /**
     * 根据地址ID修改地址城市
     * @param address 地址类
     */
    void updateCityByAddressId(Address address);

    /**
     * 根据地址ID修改地址区
     * @param address 地址类
     */
    void updateDistrictByAddressId(Address address);

    /**
     * 根据地址ID修改详细地址
     * @param address 地址类
     */
    void updateDetailAddressByAddressId(Address address);

    /**
     * 根据地址ID修改地址联系人
     * @param address 地址类
     */
    void updateContactByAddressId(Address address);

    /**
     * 根据用户ID修改地址联系人
     * @param data 地址类信息-userId&contact
     */
    void updateContactByUserId(Map<String,String> data);

    /**
     * 根据地址Id修改地址手机号
     * @param address 地址类
     */
    void updatePhoneNumByAddressId(Address address);

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

    /**
     * 根据地址ID修改地址信息
     * @param address 地址ID
     */
    void updateAddressByAddressId(Address address);
}
