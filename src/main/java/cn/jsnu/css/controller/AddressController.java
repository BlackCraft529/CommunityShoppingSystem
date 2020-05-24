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

    public String delete(String addressId) {
        return "";
    }

    @RequestMapping("/getAddressInfo")
    @ResponseBody
    public String getAddressInfo(String id) {
        JSONObject jsonObject = new JSONObject();
        try {
            Address address = addressService.findAddressByAddressId(id);
            jsonObject.put("success", true);
            jsonObject.put("address", address);
            System.out.println(address);
            System.out.println(jsonObject.toString());
        } catch (Exception e) {
            jsonObject.put("success", false);
        }
        return jsonObject.toString();
    }

    @RequestMapping("/update")
    public String update(Address address) {
        System.out.println(address);
        return "redirect:/address/list";
    }
}
