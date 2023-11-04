//
//  NewsKMPApp.swift
//  NewsKMP
//
//  Created by Dino Priyano on 04/11/23.
//

import SwiftUI
import Common

@main
struct NewsKMPApp: App {
    var body: some Scene {
        WindowGroup {
            ComposeView()
        }
    }
}

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> some UIViewController {
        return MainKt.MainViewController()
    }
    
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {
        
    }
}
