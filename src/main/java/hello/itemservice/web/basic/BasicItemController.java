//package hello.itemservice.web.basic;
//
//
//import hello.itemservice.domain.item.Item;
//import hello.itemservice.domain.item.ItemRepository;
//import lombok.RequiredArgsConstructor;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.ObjectError;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import javax.annotation.PostConstruct;
//import javax.validation.Valid;
//import java.util.List;
//
//@Controller
//@RequestMapping("/basic/items")
//@RequiredArgsConstructor
//public class BasicItemController {
//
//    private final ItemRepository itemRepository;
//
//    @GetMapping
//    public String items(Model model){
//        List<Item> items = itemRepository.findAll();
//        model.addAttribute("items", items);
//        return "basic/items";
//    }
//
//    @GetMapping("/{itemId}")
//    public String item(@PathVariable long itemId, Model model){
//        Item item = itemRepository.findById(itemId);
//        model.addAttribute("item", item);
//        return "basic/item";
//    }
//    @GetMapping("/add")
//    public String addForm(){
//        System.out.println("add");
//        return "basic/addForm";
//    }
//
////    @PostMapping("/add")
//    public String addItemV1(@RequestParam String itemName,
//                       @RequestParam int price,
//                       @RequestParam Integer quantity,
//                        Model model){
//        Item item = new Item();
//        item.setItemName(itemName);
//        item.setPrice(price);
//        item.setQuantity(quantity);
//
//        itemRepository.save(item);
//        model.addAttribute("item", item);
//
//        return "basic/item";
//    }
//
//  //  @PostMapping("/add")
//    public String addItemV2(@ModelAttribute("item") Item item , Model model){
//        itemRepository.save(item);
////        model.addAttribute("item", item);  // 자동추가 , 생략 가능
//
//        return "basic/item";
//    }
//
//  //   @PostMapping("/add")
//    public String addItemV3(@ModelAttribute Item item){
//        itemRepository.save(item);
//        return "basic/item";
//    }
//
//     //  @PostMapping("/add")
//    public String addItemV4(Item item){
//        itemRepository.save(item);
//        return "basic/item";
//    }
//     // @PostMapping("/add")
//    public String addItemV5(Item item){
//        itemRepository.save(item);
//        return "redirect:/basic/items/" + item.getId();
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity addItemV6(@Valid Item item, BindingResult bindingResult, RedirectAttributes redirectAttributes){
//        if(bindingResult.hasErrors()){
//            List<ObjectError> errorList = bindingResult.getAllErrors();
//            for (ObjectError objectError : errorList) {
//                System.out.println("error=="+objectError.getDefaultMessage());
//            }
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
//        }
//        Item savedItem = itemRepository.save(item);
//        redirectAttributes.addAttribute("itemdId", savedItem.getId());
//        redirectAttributes.addAttribute("status",true);
//
//        return ResponseEntity.ok(item);
//    }
//
//    @GetMapping("/{itemId}/edit")
//    public String editForm(@PathVariable Long itemId, Model model){
//        System.out.println("edit");
//        Item item = itemRepository.findById(itemId);
//        model.addAttribute("item", item);
//        return "basic/editForm";
//    }
//
//    @PostMapping("/{itemId}/edit")
//    public String edit(@PathVariable Long itemId,  @ModelAttribute  Item item){
//        itemRepository.update(itemId,item);
//        return "redirect:/basic/items/{itemId}";
//    }
//    @PostConstruct
//    public void init(){
//        itemRepository.save(new Item("itemA",10000,10));
//        itemRepository.save(new Item("itemB",20000,20));
//    }
//
//}
