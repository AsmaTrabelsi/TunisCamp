import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
  })
export class ImageService {


    fileToBlob(file: File): Promise<Blob> {
        return new Promise((resolve, reject) => {
          const reader = new FileReader();
          reader.onloadend = () => {
            const arrayBuffer = reader.result as ArrayBuffer;
            const blob = new Blob([arrayBuffer], { type: file.type });
            resolve(blob);
          };
          reader.onerror = () => {
            reject(new Error('Failed to read file.'));
          };
          reader.readAsArrayBuffer(file);
        });
      }
}