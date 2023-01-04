package ch8;

public class ChainedException2 {
  public static void main(String[] args) {
    try {
      install();
    } catch (InstallException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  static void install() throws InstallException {
    try {
      startInstall();
      copyFiles();
    } catch (SpaceException e) {
      InstallException ie = new InstallException("설치 예외 발생!");
      ie.initCause(e); // 원인은 SpaceException이 알아서 설명하도록 만든다.
      throw ie;
    } catch (MemoryException e) {
      InstallException ie = new InstallException("설치 예외 발생!");
      ie.initCause(e);
      throw ie;
    } finally {
      deleteTempFiles();
    }
  }

  static void startInstall() throws SpaceException, MemoryException { // 얘들은 checked exception
    if (!enoughSpace()) {
      throw new SpaceException("설치할 공간이 부족합니다.");
    }
  }

  static void copyFiles() {
    System.out.println("copyFiles()");
  }

  static void deleteTempFiles() {
    System.out.println("deleteTempFiles()");
  }

  static boolean enoughSpace() {
    return false;
  }

  static boolean enoughMemory() {
    return true;
  }
}

class InstallException extends Exception {
  InstallException(String msg) {
    super(msg);
  }
}

class SpaceException extends Exception {
  SpaceException(String msg) {
    super(msg);
  }
}

class MemoryException extends Exception {
  MemoryException(String msg) {
    super(msg);
  }
}