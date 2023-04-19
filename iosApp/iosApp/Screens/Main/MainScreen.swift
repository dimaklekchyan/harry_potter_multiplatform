//
//  MainScreen.swift
//  iosApp
//
//  Created by klekchyan on 15.04.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        MainKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct MainScreen: View {
    var body: some View {
        ComposeView().ignoresSafeArea(.keyboard)
    }
}
