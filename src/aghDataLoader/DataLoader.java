/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aghDataLoader;

import academicguidancehub.FileLocationInterface;

public abstract class DataLoader implements FileLocationInterface {
    protected String filePath;

    public DataLoader(String filePath) {
        this.filePath = filePath;
    }

    public abstract void loadData();
}
