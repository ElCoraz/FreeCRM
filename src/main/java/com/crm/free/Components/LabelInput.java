package com.crm.free.Components;

import java.util.HashMap;

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

    public LabelInput(HashMap<String, String> data) {
        super(data);

        setFields(data);
    }

    public LabelInput(String json) {
        super(json);

        setFields(new JSONObject(json));
    }

    public LabelInput(JSONObject jsonObject) {
        super(jsonObject);

        setFields(jsonObject);
    }

    @SuppressWarnings("unchecked")
    @Override
    public String atClient() {
        String template = """
            <script>
                var {tempName} = $("#{id}");

                {tempName}.on( "click", function() {
                    alert( "Event click {name}" );
                });
                {tempName}.on( "dblclick", function() {
                    alert( "Event dblclick {name}" );
                });
                {tempName}.on( "change", function() {
                    alert( "Event change {name}" );
                } );
                {tempName}.on('input', function() {
                    alert( "Event input {name}" );
                });
            </script>
        """;    

        HashMap<String, String> temp = new HashMap<>();

        temp.put("tempName", getTempName());

        return replace(template, temp);
    }

    @SuppressWarnings("unchecked")
    @Override
    public String toHTML() {
        String template = """
            <div class="form-group">
                <label for="{id}">{label}</label>
                <input type="{type}" class="form-control" id="{id}" value="{value}" placeholder="{placeholder}">
            </div>
        """;    

        return replace(template) + atClient();
    }
    
}
