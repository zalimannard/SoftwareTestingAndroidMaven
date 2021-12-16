import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonService
{
    public static JSONObject readFromJsonFile(String path)
    {
        File file = new File(path);
        InputStream inputStream = null;

        try
        {
            inputStream = new FileInputStream(file);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        try
        {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(
                        inputStream,
                        Charset.forName("UTF-8")));
            String jsonText = readAll(bufferedReader);
            JSONObject jsonObject = new JSONObject(jsonText);
            return jsonObject;
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                inputStream.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static String readAll(Reader reader) throws IOException
    {
        StringBuilder stringBuilder = new StringBuilder();
        int partString;
        while((partString = reader.read()) != -1)
        {
            stringBuilder.append((char) partString);
        }
        return stringBuilder.toString();
    }

    public static String getUrl(JSONObject jsonObject) throws JSONException
    {
        return jsonObject.getJSONObject("appium").getString("url");
    }

    public static String getApp(JSONObject jsonObject) throws JSONException
    {
        return jsonObject.getJSONObject("appium").getJSONObject("capabilities").getString("app");
    }

    public static JSONObject getCapabilities(JSONObject jsonObject)
    {
        try 
        {
            return jsonObject.getJSONObject("appium").getJSONObject("capabilities");
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
