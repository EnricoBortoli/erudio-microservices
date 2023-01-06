package br.com.erudio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsuportedMathOperationException;

@RestController
public class MathController {
	
	@RequestMapping(value="/sum/{numero1}/{numero2}", method=RequestMethod.GET)
	public Double sum(@PathVariable("numero1") String numero1,@PathVariable("numero2") String numero2) throws Exception {
		if(!isNumeric(numero1) || !isNumeric(numero2)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		Double result = convertToDouble(numero1) + convertToDouble(numero2);
		return result;
	}
	
	@RequestMapping(value="/sub/{numero1}/{numero2}", method=RequestMethod.GET)
	public Double sub(@PathVariable("numero1") String numero1,@PathVariable("numero2") String numero2) throws Exception {
		if(!isNumeric(numero1) || !isNumeric(numero2)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		Double result = convertToDouble(numero1) - convertToDouble(numero2);
		return result;
	}
	
	@RequestMapping(value="/div/{numero1}/{numero2}", method=RequestMethod.GET)
	public Double div(@PathVariable("numero1") String numero1,@PathVariable("numero2") String numero2) throws Exception {
		if(!isNumeric(numero1) || !isNumeric(numero2)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		Double result = convertToDouble(numero1) / convertToDouble(numero2);
		return result;
	}
	
	@RequestMapping(value="/mult/{numero1}/{numero2}", method=RequestMethod.GET)
	public Double mult(@PathVariable("numero1") String numero1,@PathVariable("numero2") String numero2) throws Exception {
		if(!isNumeric(numero1) || !isNumeric(numero2)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		Double result = convertToDouble(numero1) * convertToDouble(numero2);
		return result;
	}
	
	@RequestMapping(value="/med/{numero1}/{numero2}", method=RequestMethod.GET)
	public Double med(@PathVariable("numero1") String numero1,@PathVariable("numero2") String numero2) throws Exception {
		if(!isNumeric(numero1) || !isNumeric(numero2)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		Double result = (convertToDouble(numero1) + convertToDouble(numero2)) / 2;
		return result;
	}
	
	@RequestMapping(value="/raiz/{numero1}", method=RequestMethod.GET)
	public Double raiz(@PathVariable("numero1") String numero) throws Exception {
		if(!isNumeric(numero)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		Double result = (Double) Math.sqrt(convertToDouble(numero));
		return result;
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
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
}
