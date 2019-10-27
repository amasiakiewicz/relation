package contracts.posting

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should create posting"

    request {
        url "/postings"
        method POST()
        headers {
            contentType applicationJson()
        }
        body (
                date: "2018-02-06",
                account: "21312343",
                amount: [currency: "EUR", amount: "15.20"],
                description:"ol"
        )
    }

    response {
        status BAD_REQUEST()
        body(
                errors: [
                        code: "description.minLength",
                        message: "The description must have least 3 characters"
                ]
        )
    }
}
