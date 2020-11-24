import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class GeneratorSqlmap {

    public void generator() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;

        // File configFile = new File("generatorConfig.xml");
        //这样写表示，在idea运行中，根目录是工程目录，如果有父工程是父工程目录。单独运行时是运行时所在目录。
        //相当于 File configFile = new File(System.getProperty("user.dir")+"generatorConfig.xml");

        File configFile = new File(System.getProperty("user.dir")+"//config//GeneratorSqlmap//generatorConfig.xml");
        System.out.println(configFile.getAbsolutePath());

        /*
        //另一种写法，从资源目录classes文件夹中获取配置文件。经过打包之后，就是从jar包中获取配置文件。
        //打成jar包，不好修改配置。
       URL resource = GeneratorSqlmap.class.getClassLoader().getResource("generatorConfig.xml");
        String file = resource.getFile();
        File configFile = new File(file);
         */
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);

    }
    public static void main(String[] args) throws Exception {
        try {
            GeneratorSqlmap generatorSqlmap = new GeneratorSqlmap();
            generatorSqlmap.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
