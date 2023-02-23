package com.timg.inventorysys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/item")
public class Main {

	private final item_repo item_repo;

	public Main(item_repo usersRepo) {
		item_repo = usersRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@GetMapping
	public List<item> getitems(){
		return item_repo.findAll();
	}

	record NewItemRequest(
			String item_name,
			String item_details,
			String issued,
			String issuer

	){

	}

	@PostMapping
	public void add_item (@RequestBody NewItemRequest request){

			item item = new item();
			item.setItem_name(request.item_name());
			item.setItem_details(request.item_details());
			item.setIssued(request.issued());
			item.setIssuer(request.issuer());
			item_repo.save(item);
	}

	@DeleteMapping ("{item_id}")
	public void deleteitem(@PathVariable ("item_id") Integer item_id){
		item_repo.deleteById(item_id);
	}

}


