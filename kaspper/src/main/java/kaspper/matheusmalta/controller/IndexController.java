package kaspper.matheusmalta.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kaspper.matheusmalta.model.InfoBancoX;
import kaspper.matheusmalta.model.InfoBancoY;
import kaspper.matheusmalta.repository.InfoBancoXRepository;
import kaspper.matheusmalta.repository.InfoBancoYRepository;

@RestController
public class IndexController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

}
