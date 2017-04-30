import { Component, OnInit } from "@angular/core";
import { Olimpiada } from "../models/olympiad";
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Result } from '../models/result';
import { OlympiadService } from "../services/olympiad.service";


@Component ({
    selector: 'olympiad-results',
    templateUrl: 'app/olympiads/olympiad.results.component.html',
})
export class OlympiadsResultComponent implements OnInit {

    results: Result[];
    
    constructor(
        private olympiadService: OlympiadService,
        private activatedRoute: ActivatedRoute,
        ){}

    ngOnInit(){
        let id = this.activatedRoute.url.value[1].path;
        this.olympiadService.getResultList(id)
                .then(resp => this.results = resp, 
                    error => alert("Error"));
    }
}