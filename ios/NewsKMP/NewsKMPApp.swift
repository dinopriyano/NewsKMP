//
//  NewsKMPApp.swift
//  NewsKMP
//
//  Created by Dino Priyano on 04/11/23.
//

import SwiftUI
import common

@main
struct NewsKMPApp: App {
    
    init() {
        KoinKt.doInitKoin(baseUrl: "test")
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
