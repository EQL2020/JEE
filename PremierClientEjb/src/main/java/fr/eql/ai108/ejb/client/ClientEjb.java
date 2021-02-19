package fr.eql.ai108.ejb.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import fr.eql.ai108.ejb.api.ICalcul;

public class ClientEjb {

	public static void main(String[] args) {
		Properties props = new Properties();
		props.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8084");
		props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		props.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.jboss.naming.remote.client.InitialContextFactory");
		props.put("jboss.naming.client.ejb.context", true);
		
		try {
			Context ctx = new InitialContext(props);
			ICalcul proxy = (ICalcul)ctx.lookup("PremierEJB/Calcul!fr.eql.ai108.ejb.api.ICalcul");
			System.out.println(proxy.add(2, 40));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
