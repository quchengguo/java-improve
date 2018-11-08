package gof23.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/11/8.
 * 抽象构建
 */
public interface AbstractFile {
    // 杀毒
    void killVirus();
}

class ImageFile implements AbstractFile {
    String name;

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("图像文件：" + name + "进行查杀");
    }
}

class TextFile implements AbstractFile {
    String name;

    public TextFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("文本文件：" + name + "进行查杀");
    }
}

class VideoFile implements AbstractFile {
    String name;

    public VideoFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("视频文件：" + name + "进行查杀");
    }
}

// 容器组件
class Folder implements AbstractFile {
    private String name;
    // 存放子节点
    private List<AbstractFile> list = new ArrayList<AbstractFile>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(AbstractFile file) {
        list.add(file);
    }

    public void remove(AbstractFile file) {
        list.remove(file);
    }

    public AbstractFile getChild(int index) {
        return list.get(index);
    }

    @Override
    public void killVirus() {
        System.out.println("文件夹:" + name + "进行查杀");
        for (AbstractFile file : list) {
            // 递归删除
            file.killVirus();
        }
    }
}

