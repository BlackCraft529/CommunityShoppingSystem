package cn.jsnu.css.controller;

import cn.jsnu.css.pojo.Address;
import cn.jsnu.css.pojo.User;
import cn.jsnu.css.service.AddressService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 李广帅
 * @date 2020/5/25 1:07 上午
 */
@Controller
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;


    @RequestMapping("/list")
    public String list(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<Address> addressList = addressService.findAddressByUserId(user.getUserId());
        model.addAttribute("addressList", addressList);
        return "addressList";
    }


    @RequestMapping("/add")
    public String add(Address address, HttpSession session) {
        User user = (User) session.getAttribute("user");
        addressService.addAddress(user.getUserId(), address.getProvince(), address.getCity(), address.getDistrict(), address.getDetailAddress(), address.getContact(), address.getPhoneNum());
        return "redirect:/address/list";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(String addressId) {
        JSONObject jsonObject = new JSONObject();
        try {
            addressService.deleteAddressByAddressId(addressId);
            jsonObject.put("success", true);
        } catch (Exception e) {
            jsonObject.put("success", false);
        }
        return jsonObject.toString();
    }

    @RequestMapping(value = "/getAddressInfo", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getAddressInfo(String id) {
        JSONObject jsonObject = new JSONObject();
        try {
            Address address = addressService.findAddressByAddressId(id);
            jsonObject.put("success", true);
            jsonObject.put("address", address);
        } catch (Exception e) {
            jsonObject.put("success", false);
        }
        return jsonObject.toString();
    }

    @RequestMapping(value = "/update", produces = "text/html;charset=UTF-8")
    public String update(Address address, HttpSession session) {
        try {
            User user = (User) session.getAttribute("user");
            address.setUserId(user.getUserId());
            addressService.updateAddressByAddressId(address);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/address/list";
    }
}
