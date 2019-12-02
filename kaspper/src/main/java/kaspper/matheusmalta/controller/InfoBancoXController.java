package kaspper.matheusmalta.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kaspper.matheusmalta.model.InfoBancoX;
import kaspper.matheusmalta.model.InfoBancoY;
import kaspper.matheusmalta.repository.InfoBancoXRepository;
import kaspper.matheusmalta.repository.InfoBancoYRepository;

@Controller
public class InfoBancoXController {
	
	@Autowired
	private InfoBancoXRepository infoBancoXRep;

	@Autowired
	private InfoBancoYRepository infoBancoYRep;

	@GetMapping(value = "/linha", produces = "application/json")
	@RequestMapping("/linha")
	public ResponseEntity<String> retLinha(@Param(value = "linha") String linha,
			@Param(value = "instRemet") InfoBancoX instRemet, @Param(value = "instDest") InfoBancoY instDest) {

		InfoBancoX ibx = new InfoBancoX();
		InfoBancoY iby = new InfoBancoY();

		// Alimentando os dados da instituição remetente
		ibx.setTpTransacao(linha.substring(0, 3));
		ibx.setAgencia(Integer.parseInt(linha.substring(3, 7)));
		ibx.setConta(Integer.parseInt(linha.substring(7, 12)));
		ibx.setdConta(Integer.parseInt(linha.substring(12, 13)));
		ibx.setFavorecido(linha.substring(13, 43));
		ibx.setCpf(linha.substring(43, 54));
		ibx.setVlInteiro(Integer.parseInt(linha.substring(54, 59)));
		ibx.setVlDecimal(Integer.parseInt(linha.substring(59, 61)));
		ibx.setDtTransacao(linha.substring(61, 69));

		infoBancoXRep.save(ibx);

		// Inserindo os dados da instituição destinatária
		iby.setCpf(ibx.getCpf());
		iby.setFavorecido(ibx.getFavorecido());
		iby.setAgencia(ibx.getAgencia());
		iby.setConta(ibx.getConta() + ibx.getdConta());
		iby.setVlDecimal(ibx.getVlInteiro() + (ibx.getVlDecimal() / 100));
		iby.setTpTransacao(ibx.getTpTransacao());
		iby.setDtTransacao(ibx.getDtTransacao().substring(0, 4) + ibx.getDtTransacao().substring(6, 8));

		infoBancoYRep.save(iby);

		// Gerando a linha de saída - CPF
		String linhaRet = linha.substring(43, 54);

		// Gerando a linha de saída - Favorecido
		linhaRet = linhaRet + linha.substring(13, 43);

		// Gerando a linha de saída - Agência
		linhaRet = linhaRet + linha.substring(3, 7);

		// Gerando a linha de saída - Conta com Dígito
		linhaRet = linhaRet + linha.substring(7, 13);

		// Gerando a linha de saída - Valor
		linhaRet = linhaRet + linha.substring(54, 61);

		// Gerando a linha de saída - Tipo de Transação
		linhaRet = linhaRet + linha.substring(0, 3);

		// Gerando a linha de saída - Data da Transação
		linhaRet = linhaRet + linha.substring(61, 65) + linha.substring(67, 69);

		return ResponseEntity.ok(linhaRet);

	}

	@GetMapping(value = "/linhas", produces = "application/json")
	@RequestMapping("/linhas")
	public ResponseEntity<List<String>> retLinha(@Param(value = "listaLinhas") List<String> listaLinhas,
			@Param(value = "instRemet") InfoBancoX instRemet, @Param(value = "instDest") InfoBancoY instDest) {

		List<String> linhas = listaLinhas;

		List<String> linhasRet = new ArrayList<String>();

		for (String linha : linhas) {

			InfoBancoX ibx = new InfoBancoX();
			InfoBancoY iby = new InfoBancoY();

			// Alimentando os dados da instituição remetente
			ibx.setTpTransacao(linha.substring(0, 3));
			ibx.setAgencia(Integer.parseInt(linha.substring(3, 7)));
			ibx.setConta(Integer.parseInt(linha.substring(7, 12)));
			ibx.setdConta(Integer.parseInt(linha.substring(12, 13)));
			ibx.setFavorecido(linha.substring(13, 43));
			ibx.setCpf(linha.substring(43, 54));
			ibx.setVlInteiro(Integer.parseInt(linha.substring(54, 59)));
			ibx.setVlDecimal(Integer.parseInt(linha.substring(59, 61)));
			ibx.setDtTransacao(linha.substring(61, 69));

			infoBancoXRep.save(ibx);

			// Inserindo os dados da instituição destinatária
			iby.setInfoBancoY(ibx);
			infoBancoYRep.save(iby);

			// Gerando a linha de saída - CPF
			String linhaRet = linha.substring(43, 54);

			// Gerando a linha de saída - Favorecido
			linhaRet = linhaRet + linha.substring(13, 43);

			// Gerando a linha de saída - Agência
			linhaRet = linhaRet + linha.substring(3, 7);

			// Gerando a linha de saída - Conta com Dígito
			linhaRet = linhaRet + linha.substring(7, 13);

			// Gerando a linha de saída - Valor
			linhaRet = linhaRet + linha.substring(54, 61);

			// Gerando a linha de saída - Tipo de Transação
			linhaRet = linhaRet + linha.substring(0, 3);

			// Gerando a linha de saída - Data da Transação
			linhaRet = linhaRet + linha.substring(61, 65) + linha.substring(67, 69);

			linhasRet.add(linhaRet);

		}

		return ResponseEntity.ok(linhasRet);

	}

	@GetMapping(value = "/transacoes}", produces = "application/json")
	@RequestMapping("/transacoes")
	public ResponseEntity<List<InfoBancoX>> retTransacoes(@Param(value = "infoBancoX") InfoBancoX infoBancoX) {

		List<InfoBancoX> lista = (List<InfoBancoX>) infoBancoXRep.findAll();

		return new ResponseEntity<List<InfoBancoX>>(lista, HttpStatus.OK);

	}
}
