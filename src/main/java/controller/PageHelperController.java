//package controller;
//
//import model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/pageHelper")
//public class PageHelperController {
//    @Autowired
//    private PageTestService pageTestService;
//
//    @RequestMapping(value = "/requestTest", method = RequestMethod.GET)
//    @ResponseBody
//    public List<User> requestTest(
//            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
//            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize
//    ) {
//        return pageTestService.selectPage(pageNum, pageSize);
//    }
//}
