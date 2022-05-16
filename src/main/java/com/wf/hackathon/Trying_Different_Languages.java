package com.wf.hackathon;

import java.io.IOException;

import com.darkprograms.speech.synthesiser.SynthesiserV2;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

/**
 * This is where all begins .
 * 
 * 
 *
 */
public class Trying_Different_Languages {
	private static final String ENGLISH="en";
	private static final String HINDI="hi";
	private static final String RUSSIAN="rs";
	private static final String CHINEESE="zh-CN";
	private static final String ARABIC="ar";
	private static final String POLISH="pl";
	
	//Create a Synthesizer instance
	SynthesiserV2 synthesizer = new SynthesiserV2("AIzaSyBOti4mM-6x9WDnZIjIeyEU21OpBXqWBgw");
	
	/**
	 * Constructor
	 */
	public Trying_Different_Languages(String language) {
		//we have hardcoded the translation for demo.We will be using google translator api to convert the text to specific language
		//https://translation.googleapis.com/language/translate/v2

		
		switch(language) {
		  case "ENGLISH":
			  speak("Sanjiv");
		    break;
		  case "HINDI":
		  speak("संजीव"); 
		    break;
		  case "RUSSIAN":
			  speak("Санджив"); //russian
		    break;
		  case "CHINEESE":
			  speak("桑吉夫");//chineese 
		    break;
		  case "ARABIC":
			  speak("سانجيف");//arabic
			  break;
		  case "POLISH":
			  speak("Sandżiw");//polish
			  break;
		  default:
			  speak("Sanjiv");
		} 
			
	}
	
	/**
	 * 
	 * 
	 * @param text
	 */
	public void speak(String text) {
		System.out.println(text);
		
		//Create a new Thread because JLayer is running on the current Thread and will make the application to lag
		Thread thread = new Thread(() -> {
			try {
				
				//we are making use of J.A.R.V.I.S. (Java-Speech-API) provided by google to pronounce the names
				AdvancedPlayer player = new AdvancedPlayer(synthesizer.getMP3Data(text));
				player.play();
				
				System.out.println("Successfully got back synthesizer data");
				
			} catch (IOException | JavaLayerException e) {
				
				e.printStackTrace(); 
			}
		});
		
		//We don't want the application to terminate before this Thread terminates
		thread.setDaemon(false);
		
		
		//Start the Thread
		thread.start();
		
	}
	
	
}
