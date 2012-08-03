package org.qii.weiciyuan.support.file;

import ch.boye.httpclientandroidlib.HttpEntity;
import ch.boye.httpclientandroidlib.HttpResponse;
import ch.boye.httpclientandroidlib.HttpStatus;
import ch.boye.httpclientandroidlib.StatusLine;

import java.io.*;

/**
 * User: Jiang Qi
 * Date: 12-8-3
 * Time: 上午9:44
 */
public class FileDownloaderHttpHelper {


    public static String saveFile(String url, HttpResponse response) {

        StatusLine status = response.getStatusLine();
        int statusCode = status.getStatusCode();


        if (statusCode != HttpStatus.SC_OK) {
            return dealWithError(response);
        }


        return saveFileAndGetFileRelativePath(response, url);

    }

    private static String dealWithError(HttpResponse response) {

        return "";
    }

    private static String saveFileAndGetFileRelativePath(HttpResponse response, String url) {
        HttpEntity httpEntity = response.getEntity();
        String imageRelativePath = FileManager.getFileRelativePathFromUrl(url);
        File file = FileManager.creatNewFileInSdcard(imageRelativePath);
        FileOutputStream out = null;
        InputStream in = null;
        String result = "";
        if (file != null) {
            try {
                int bytesum = 0;
                int byteread = 0;
                out = new FileOutputStream(file);
                in = httpEntity.getContent();
                byte[] buffer = new byte[1444];
                while ((byteread = in.read(buffer)) != -1) {
                    bytesum += byteread;
                    out.write(buffer, 0, byteread);
                }
                result = imageRelativePath;
            } catch (FileNotFoundException ignored) {
            } catch (IOException e) {

            } finally {

                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {

                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {

                    }
                }

            }

        }
        return result;
    }




}