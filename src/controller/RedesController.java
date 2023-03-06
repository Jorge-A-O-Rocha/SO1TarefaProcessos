package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	//construtor
	public RedesController() {
		super();
	}
	
	//Nome do Sistema
	private String os() {
		String os = System.getProperty("os.name");
		return os;
	} 
	
	//Chamado do IP pelo So
	public void ip() {
		String os = os();
		if(os.contains("Windows")) {
			Process p;
			try {
				p = Runtime.getRuntime().exec("IPCONFIG");
				InputStream fluxo  = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				String adaptador = "";
				String ipv4 = "";
				while(linha != null) {
					linha= buffer.readLine();
					
					if (linha.contains("Adaptador")) {
	                    // Extrai o nome do adaptador de rede
	                    adaptador = linha.split(":")[0].trim();
	                }
					
					// Verifica se a linha contém um endereço IPv4
	                if (linha.contains("Endere�o IPv4")) {
	                    // Extrai o endereço IPv4
	                    ipv4 = linha.split(":") [0].trim();
	                    System.out.println(adaptador + ":" + ipv4);
	                }
				}
				buffer.close();
				leitor.close();
				fluxo.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else if (os.contains("Linux")){
			Process p;
			try {
				p = Runtime.getRuntime().exec("IFCONFIG");
				InputStream fluxo  = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				String adaptador = "";
				String ipv4 = "";
				while(linha != null) {
					linha= buffer.readLine();
					
					if (linha.contains("Adaptador")) {
	                    // Extrai o nome do adaptador de rede
	                    adaptador = linha.split(":")[0].trim();
	                }
					
					// Verifica se a linha contém um endereço IPv4
	                if (linha.contains("Endere�o IPv4")) {
	                    // Extrai o endereço IPv4
	                    ipv4 = linha.split(":") [0].trim();
	                    System.out.println(adaptador + ":fff " + ipv4);
	                }
				}
				buffer.close();
				leitor.close();
				fluxo.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else {
			System.out.println("SO não encontrado");
		}
		
	} 
	
	public void ping() {
		String os = os();
		if(os.contains("Windows")) {
			Process p;
			try {
				p = Runtime.getRuntime().exec("PING -4 -n 10 www.google.com.br");
				InputStream fluxo  = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				
				int cont=0;
				int total  = 0;
				String num="";
				double media= 0;
				while(linha != null) {
					linha= buffer.readLine();
					 System.out.println(linha);
					
					if (linha.contains("tempo=")) {
						num = linha;
	                    total = total +  (Integer.parseInt(num.substring(44, 53)));
	                    cont++;
	                }
					
					
				}
				 System.out.println("media de "+ (total/cont));
					
				buffer.close();
				leitor.close();
				fluxo.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if(os.contains("Linux")) {
			
		}
		
	} 
	
	
	
	
	
	

}
