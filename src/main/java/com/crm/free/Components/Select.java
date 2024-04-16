package com.crm.free.Components;

import org.json.JSONObject;

public class Select extends Component {

    protected String id = "";
    protected String name = "";
    protected String value = "";
    protected String label = "";

    protected String values[] = new String[0];

    public Select(String id, String name, String label, String value, String values[]) {
        super(id, name);

        this.id = id;
        this.name = name;
        this.value = value;
        this.label = label;

        this.values = values;
    }

    public Select(String json) {
        super(json);

        setFields(new JSONObject(json));
    }

    public Select(JSONObject jsonObject) {
        super(jsonObject);

        setFields(jsonObject);
    }

    @Override
    public String toHTML() throws IllegalArgumentException, IllegalAccessException {
        String options = "";

        for(String value:values) {
            options += "<option>" + value + "</option>";
        }

        String template = """
            <div class="form-group">
                <label>{label}</label>
                <select class="custom-select" id="{id}" name="{id}" value="{value}">
                    """ + options + """
                </select>
            </div>
        """;    

        return replace(template);
    }
 
}
