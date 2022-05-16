package com.wf.hackathon;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.darkprograms.speech.synthesiser.SynthesiserV2;
import com.google.api.client.util.IOUtils;



@RestController
public class PronunciationController {
	private static final String ENGLISH="en";
	private static final String HINDI="hi";
	private static final String RUSSIAN="rs";
	private static final String CHINEESE="zh-CN";
	private static final String ARABIC="ar";
	private static final String POLISH="pl";
	
	/*@RequestMapping(method = RequestMethod.GET, value = "/api/name/pronunciation")
	public String namePronunciation(@RequestParam String name,@RequestParam Test selectLanguage) {
		Trying_Different_Languages tl= new Trying_Different_Languages(selectLanguage.name());
		
		return "Success";
	}*/
	
	
	@GetMapping(value = "/api/name/pronunciation", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<ByteArrayResource> downloadAudio(@RequestParam String name, @RequestParam Test selectLanguage) throws IOException {
      //  Trying_Different_Languages tl = new Trying_Different_Languages();
		SynthesiserV2 synthesizer = new SynthesiserV2("AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw");
        String words = getLanguage(selectLanguage.name());
        InputStream inputStream = synthesizer.getMP3Data(words);
        ByteArrayOutputStream targetStream = new ByteArrayOutputStream();
        //inputStream.transferTo(targetStream);
        IOUtils.copy(inputStream, targetStream);
        HttpHeaders headers = new HttpHeaders();
       // headers.add("Content-discription", "inline; filename=test.mp3");
        headers.add("Content-Disposition", "inline; filename=namepronounciation.mp3");

        new ByteArrayResource(targetStream.toByteArray());
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new ByteArrayResource(targetStream.toByteArray()));
    }

	
	public String getLanguage (String language) {
		//we have hardcoded the translation for demo.We will be using google translator api to convert the text to specific language
		//https://translation.googleapis.com/language/translate/v2

		
		switch(language) {
		  case "ENGLISH":
			  return "Jose";
		    
		  case "HINDI":
			  return "जोस"; 
		    
		  case "RUSSIAN":
			  return "Хосе"; //russian
		    
		  case "CHINESE":
			  return "Hé sāi";//chinese 
		    
		  case "ARABIC":
			  return "جوزيه";//arabic
			  
		  case "SPANISH":
			  return "José";
			  
		  case "FRENCH":
			  return "José";
			  
		  default:
			  return "Jose";
		} 
			
	}
	
}

