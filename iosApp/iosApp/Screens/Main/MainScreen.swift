//
//  MainScreen.swift
//  iosApp
//
//  Created by klekchyan on 15.04.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct MainScreen: View {
    var body: some View {
        VStack {
            VStack {
                Spacer().frame(height: 36)
                Text("Characters")
                    .foregroundColor(Color.onPrimary)
                    .fontWeight(.bold)
                    .font(.system(size: 24))
            }
        }
    }
}

struct MainScreen_Previews: PreviewProvider {
    static var previews: some View {
        MainScreen().background(Color.secondaryBackground)
    }
}
