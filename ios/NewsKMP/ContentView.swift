//
//  ContentView.swift
//  NewsKMP
//
//  Created by Dino Priyano on 04/11/23.
//

import SwiftUI
import common

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> some UIViewController {
        return MainKt.MainViewController()
    }
    
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {
        
    }
}


struct ContentView: View {
    var body: some View {
        ComposeView()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
