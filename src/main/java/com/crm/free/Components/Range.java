package com.crm.free.Components;

import org.json.JSONObject;

public class Range extends Component {

    protected String id = "";
    protected String name = "";
    protected String label = "";

    public Range(String id, String name, String label) {
        super(id, name);

        this.id = id;
        this.name = name;
        this.label = label;
    }

    public Range(String json) {
        super(json);

        setFields(new JSONObject(json));
    }

    public Range(JSONObject jsonObject) {
        super(jsonObject);

        setFields(jsonObject);
    }

    @SuppressWarnings("unchecked")
    @Override
    public String atClient() {
        String template = """
            <script>
            </script>
        """;    

        return replace(template);
    }

    @SuppressWarnings("unchecked")
    @Override
    public String toHTML() {
        String template = """
            <div class="form-group">
                <label for="{id}">{label}</label>
                <input type="range" class="custom-range" id="{id}" name="{name}">
            </div>
        """;    

        return replace(template);
    }
 
}
