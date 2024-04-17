package com.crm.free.Components;

import java.util.HashMap;

import org.json.JSONObject;

public class Button extends Component {

    protected String id = "";
    protected String name = "";
    protected String text = "";

    public Button(String id, String name, String text) {
        super(id, name);

        this.id = id;
        this.name = name;
        this.text = text;
    }

    public Button(HashMap<String, String> data) {
        super(data);

        setFields(data);
    }

    public Button(String json) {
        super(json);

        setFields(new JSONObject(json));
    }

    public Button(JSONObject jsonObject) {
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

                    var name = getName();
                    
                    alert( "Event click {name}" );
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
                <button type="button" class="btn btn-block btn-primary" id="{id}" name="{name}">{text}</button>
            """;    

        return replace(template) + atClient();
    }
 
}
