public void sacarArchivoJar(String Archivo,String RutaDescarga){

try {
            InputStream in = getClass().getResourceAsStream(Archivo);
            OutputStream out = new FileOutputStream(RutaDescarga);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
            System.out.print("Copiado con exito");
        } catch (Exception e) {
            System.out.println(e);
        }

}
}
