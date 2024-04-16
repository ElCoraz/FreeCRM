package com.crm.free.Components;

import org.json.JSONObject;

public class LabelInput extends Component {

    protected String id = "";
    protected String type = "";
    protected String name = "";
    protected String label = "";
    protected String value = "";
    protected String placeholder = "";

    public LabelInput(String id, String type, String name, String label, String value, String placeholder) {
        super(id, name);

        this.id = id;
        this.type = type;
        this.name = name;
        this.label = label + ":";
        this.value = value;
        this.placeholder = placeholder;
    }

    public LabelInput(String json) {
        super(json);

        setFields(new JSONObject(json));
    }

    public LabelInput(JSONObject jsonObject) {
        super(jsonObject);

        setFields(jsonObject);
    }

    public String toHTML() throws IllegalArgumentException, IllegalAccessException {
        String template = """
            <div class="form-group">
                <label for="{id}">{label}</label>
                <input type="{type}" class="form-control" id="{id}" value="{value}" placeholder="{placeholder}">
            </div>
        """;    

        return replace(template);
    }
    
}
