package com.crm.free.Components;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.json.JSONObject;

public class Component implements HTML {

    @SuppressWarnings("unused")
    private String id = "";
    @SuppressWarnings("unused")
    private String name = "";

    public Component(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Component(HashMap<String, String> data) {
        setFields(data);
    }

    public Component(String json) {
        setFields(new JSONObject(json));
    }

    public Component(JSONObject jsonObject) {
        setFields(jsonObject);
    }

    public void add(Component component) { }

    @SuppressWarnings("deprecation")
    protected void setFields(HashMap<String, String> data) {
        data.forEach((key, value) -> {
            Field[] fields = this.getClass().getDeclaredFields();

            for(Field field:fields) {
                if(!field.isAccessible()) {
                    field.setAccessible(true);

                    if (!field.getName().equals(key)) {
                        continue;
                    }
                    
                    Class<?> type = field.getType();
    
                    if(type.equals(Integer.class)) {
                        try {
                            field.set(this, value);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if(type.equals(String.class)) {
                        try {
                            field.set(this, value);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (type.equals(Date.class)) {
                        try {
                            field.set(this, new Date(value));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    field.setAccessible(false);
                }
            }
        });
    }

    @SuppressWarnings("deprecation")
    protected void setFields(JSONObject jsonObject) {
        jsonObject.keySet().forEach(key -> {
            Field[] fields = this.getClass().getDeclaredFields();

            for(Field field:fields) {
                if(!field.isAccessible()) {
                    field.setAccessible(true);

                    if (!field.getName().equals(key)) {
                        continue;
                    }
                    
                    Class<?> type = field.getType();
    
                    if(type.equals(Integer.class)) {
                        try {
                            field.set(this, jsonObject.getInt(key));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if(type.equals(String.class)) {
                        try {
                            field.set(this, jsonObject.getString(key));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (type.equals(Date.class)) {
                        try {
                            field.set(this, new Date(jsonObject.getString(key)));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (type.equals(Array.class)) {
                        try {
                            field.set(this, jsonObject.getJSONArray(key));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    field.setAccessible(false);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    protected String replace(String template, HashMap<String, String> ... temps) {
        try {

        Map<String, Object> values = new HashMap<>();

        for (Field field : this.getClass().getDeclaredFields()) {
            values.put(field.getName(), field.get(this).toString());
        }  
        
        for (HashMap<String, String> temp : temps) {
            for (Entry<String, String> value : temp.entrySet()) {
                values.put(value.getKey(), value.getValue().toString());
            }
        }

        for (Map.Entry<String, Object> value : values.entrySet()) {
            template = template.replace("{" + value.getKey() + "}", value.getValue().toString());
        }
        
        return template;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String getTempName() {
        return (new Random()).ints(97, 123)
          .limit(10)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();
    }

    @Override
    public String atClient() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atClient'");
    }

    @Override
    public String toHTML() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toHTML'");
    }

}
