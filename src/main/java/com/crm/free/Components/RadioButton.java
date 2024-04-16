package com.crm.free.Components;

import org.json.JSONObject;

public class RadioButton extends Component {

    protected String id = "";
    protected String name = "";
    protected String label = "";

    public RadioButton(String id, String name, String label) {
        super(id, name);

        this.id = id;
        this.name = name;
        this.label = label;
    }

    public RadioButton(String json) {
        super(json);

        setFields(new JSONObject(json));
    }

    public RadioButton(JSONObject jsonObject) {
        super(jsonObject);

        setFields(jsonObject);
    }

    public String toHTML() throws IllegalArgumentException, IllegalAccessException {
        String template = """
            <div class="custom-control custom-radio">
                <input class="custom-control-input" type="radio" id="{id}" name="{name}">
                <label for="{id}" class="custom-control-label">{label}</label>
            </div>
        """;    

        return replace(template);
    }
 
}
