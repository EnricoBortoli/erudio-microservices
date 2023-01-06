package br.com.erudio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
	
	@RequestMapping(value="/sum/numero1/numero2", method=RequestMethod.GET)
	public Double sum(@PathVariable("numero1") String numero1,@PathVariable("numero2") String numero2) throws Exception {
		if(!isNumeric(numero1) || !isNumeric(numero2)) {
			throw new Exception();
		}
		Double sum = convertToDouble(numero1) + convertToDouble(numero2);
		return sum;
	}

	private Double convertToDouble(String StrNumber) {
		if(StrNumber == null) return 0D;
		String number = StrNumber.replaceAll(",",".");
		if (isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String StrNumber) {
		if(StrNumber == null) return false;
		String number = StrNumber.replaceAll(",",".");
		return number.matches("[-+]?[0-9]*\\\\.?[0-9]+");
	}
	
}
