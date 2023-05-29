package com.timg.inventorysys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("api/")
public class Main {

	private final item_repo item_repo;

	public Main(item_repo usersRepo) {
		item_repo = usersRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@GetMapping
	public String hello(){

		return  "sample api";

	}

	@GetMapping ("/showall")
	public List<item> getitems(){
		return item_repo.findAll();
	}

	record ItemRequest(

			Integer id,
			String item_name,
			String item_details,
			String issued,
			String issuer

	){
		public String getitem_name() {
			return item_name;
		}
		public String getitem_details() {
			return item_details;
		}
		public String getissued() {
			return issued;
		}
		public String getissuer() {
			return issuer;
		}
	}

	@PostMapping("/newitem")
	public void add_item (@RequestBody ItemRequest request){

			item item = new item();
			item.setItem_name(request.item_name());
			item.setItem_details(request.item_details());
			item.setIssued(request.issued());
			item.setIssuer(request.issuer());
			item_repo.save(item);
	}

	@DeleteMapping ("/deleteitem/{item_id}")
	public void deleteitem(@PathVariable ("item_id") Integer item_id){
		item_repo.deleteById(item_id);
	}

	@PutMapping("/updateitem/{item_id}")
	public item update_item(@PathVariable ("item_id") Integer item_id, @RequestBody ItemRequest request) {



		Optional<item> optionalItem = item_repo.findById(item_id);
		if (optionalItem.isPresent()) {
			item item = optionalItem.get();
			item.setItem_name(request.getitem_name());
			item.setItem_details(request.getitem_details());
			item.setIssued(request.getissued());
			item.setIssuer(request.getissuer());
			return item_repo.save(item);
		} else {

		}
		return null;
	}
}







