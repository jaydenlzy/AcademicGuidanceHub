/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aghDataLoader;

import academicguidancehub.FileLocationInterface;
import academicguidancehub.FileReaderUtils;

public abstract class DataLoader implements FileLocationInterface {
    protected String filePath;
    protected FileReaderUtils fileReaderUtils;

    public DataLoader(String filePath) {
        this.filePath = filePath;
        this.fileReaderUtils = new FileReaderUtils();
    }

    public abstract void loadData();
}
