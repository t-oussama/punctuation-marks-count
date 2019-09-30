import { Component, OnInit } from '@angular/core';
import { PunctuationCountService } from '../../core/services/punctuation-count/punctuation-count.service';

@Component({
  selector: 'app-punctuation-count',
  templateUrl: './punctuation-count.component.html',
  styleUrls: ['./punctuation-count.component.css']
})
export class PunctuationCountComponent implements OnInit {

  counter = 0;
  totalCount = 0;
  text = '';


  constructor(private punctuationCountService: PunctuationCountService) { }

  ngOnInit() {
  }


  // Gets punctuation markers count from the server and sets it for the view.
  public async count() {
    console.log('counting !');
    this.punctuationCountService.countPunctuation(this.text).subscribe(async res => {
      this.totalCount = res.countValue;
    });
  }

  // When the file is fully loaded, it reads it's contents and sends them to the server for a punctuation markers count
  public handleFileInput(files) {
    const fileReader = new FileReader();
    fileReader.readAsText(files[0]);
    fileReader.onload = e => {
      this.text = fileReader.result as string;
      this.count();
    };
  }

}
