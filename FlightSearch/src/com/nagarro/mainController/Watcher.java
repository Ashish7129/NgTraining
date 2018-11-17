package com.nagarro.mainController;


import com.nagarro.input.*;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;


public class Watcher {
	public static void watcher() {
		Path dir = Paths
				.get("data");
		try {
			while (true) {
				WatchService watcher = dir.getFileSystem().newWatchService();
				dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
						StandardWatchEventKinds.ENTRY_MODIFY);
				WatchKey watchKey = watcher.poll(5000, TimeUnit.MILLISECONDS); 
//				System.out.println(watchKey);
				if(watchKey != null) {
					for (WatchEvent<?> event : watchKey.pollEvents()) {
						String file_name =  "data\\" + event.context().toString();
						if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
							System.out.println("Created: " + file_name);
							if(!(DirectoryReader.flightInfo.containsKey(file_name))) {
								DirectoryReader.flightInfo.put(file_name,DirectoryReader.readFile(file_name));
							}
						}
						if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
							System.out.println("Delete: " + file_name);
							if(DirectoryReader.flightInfo.containsKey(file_name)) {
								DirectoryReader.flightInfo.remove(file_name);
							}
							
						}
						if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
							System.out.println("Modify: " + event.context().toString());
							if(DirectoryReader.flightInfo.containsKey(file_name)) {
								//System.out.println(DirectoryReader.flightInfo.values());
								DirectoryReader.flightInfo.put(file_name,DirectoryReader.readFile(file_name));
							}}
						}
					watchKey.reset();
				}
				else{
					break;}
			}}catch (InterruptedException interruptedException) {
	        System.out.println("Thread got interrupted:" + interruptedException);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}