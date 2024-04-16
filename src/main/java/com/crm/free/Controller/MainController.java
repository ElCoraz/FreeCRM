package com.crm.free.Controller;

import java.io.IOException;
import org.xml.sax.InputSource;
import java.io.StringReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.crm.free.Components.Component;

@Controller
public class MainController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

	private Component getClass(String name, @SuppressWarnings("rawtypes") HashMap values) throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> c = Class.forName("com.crm.free.Components." + name);
		Constructor<?> cons = c.getConstructor(HashMap.class);
		return (Component) cons.newInstance(values);
}

	@GetMapping("/read")
	@ResponseBody
	public String read() throws ParserConfigurationException, SAXException, IOException, IllegalArgumentException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, InvocationTargetException {
		
		//Card card = null;

		String xmlString = """
			<root>
				<Card 
					id="id_form_1" 
					title="Title form"
					footer="Footer title">
					<LabelInput
						id="label_id_1"
						type="text"
						name="label_name_1"
						label="label_label_1"
						value="label_value_1"
						placeholder="label_placeholder_1"></LabelInput>
					<LabelInput
						id="label_id_2"
						type="text"
						name="label_name_2"
						label="label_label_2"
						value="label_value_2"
						placeholder="label_placeholder_2"></LabelInput>
					<Button 
						id="button_id_1"
						name="button_name_1"
						text="button_text_1"></Button>
				</Card>
			</root>
		""";

		DocumentBuilder builder = (DocumentBuilderFactory.newInstance()).newDocumentBuilder();

		Document document = builder.parse(new InputSource(new StringReader(xmlString)));

		NodeList nodeList = document.getElementsByTagName("Card");

		if (nodeList.getLength() == 1) {

			Node form = nodeList.item(0);
			
			NamedNodeMap attributesForm = form.getAttributes();

			int countAttributesForm = attributesForm.getLength();

			HashMap<String, String> formValues = new HashMap<>();

			if (countAttributesForm > 0) {
				for(int i = 0; i < countAttributesForm; i++) {
					formValues.put(attributesForm.item(i).getNodeName(), attributesForm.item(i).getNodeValue());
				}
			}

			Component card = getClass(form.getNodeName(), formValues);

			NodeList childNodes = form.getChildNodes();

			int countElements = childNodes.getLength();

			if (countElements > 0) {

				for (int i = 0; i < countElements; i++) {
					Node element = childNodes.item(i);

					if (element.getNodeType() != Node.ELEMENT_NODE) {
						continue;
					}
		
					NamedNodeMap attributes = element.getAttributes();

					int countAttributes = attributes.getLength();
		
					HashMap<String, String> elementValues = new HashMap<>();

					if (countAttributes > 0) {
						for(int j = 0; j < countAttributes; j++) {
							elementValues.put(attributes.item(j).getNodeName() ,attributes.item(j).getNodeValue());
						}
					}

					card.add(getClass(element.getNodeName(), elementValues));
				}
			}
			return card.toHTML();
		}
		return "";
	}
}
